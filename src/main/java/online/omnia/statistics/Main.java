package online.omnia.statistics;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by lollipop on 14.11.2017.
 */
public class Main {
    public static int days;
    public static long deltaTime = 24 * 60 * 60 * 1000;

    public static void main(String[] args) throws ParseException {
        if (args.length != 1) {
            return;
        }
        if (!args[0].matches("\\d+")) return;
        if (Integer.parseInt(args[0]) == 0) {
            deltaTime = 0;
        }
        days = Integer.parseInt(args[0]);

        List<TrackersEntity> trackersEntities = MySQLDaoImpl.getInstance().getTrackers();

        String answer;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(List.class, new CampaignsListJsonDeserializer());
        Gson gson = builder.create();
        List<CampaignEntity> campaignEntities;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC/Etc"));
        for (TrackersEntity trackersEntity : trackersEntities) {
            for (int i = 0; i <= days; i++) {
                if (!trackersEntity.getPrefix().equals("333") && trackersEntity.getApiKey() != null && trackersEntity.getDomain() != null) {
                    answer = HttpMethodUtils.getMethod(trackersEntity.getDomain() + "/?order=2&type=DESC&type_stat=0&search_name=&user_group=all&status=1&group=all&traffic_source=all&date=1&date_s="
                            + simpleDateFormat.format(new Date(System.currentTimeMillis() - deltaTime - i * 24L * 60 * 60 * 1000)) + "&date_e="
                            + simpleDateFormat.format(new Date(System.currentTimeMillis() - deltaTime - i * 24L * 60 * 60 * 1000))
                            + "&page=Campaigns&api_key=" + trackersEntity.getApiKey(), null);
                    campaignEntities = gson.fromJson(answer, List.class);
                    CampaignEntity tempEntity;
                    if (campaignEntities == null) continue;
                    for (CampaignEntity campaignEntity : campaignEntities) {
                        campaignEntity.setDate(simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis() - deltaTime - i * 24L * 60 * 60 * 1000))));
                        campaignEntity.setTrackerId(Integer.parseInt(trackersEntity.getPrefix()));
                        if (campaignEntity.getClicks() != 0 || campaignEntity.getBots() != 0 || campaignEntity.getProfit() != 0 ||
                                campaignEntity.getROI() != 0 || campaignEntity.getLP_CTR() != 0 || campaignEntity.getLeads() != 0 ||
                                campaignEntity.getCR() != 0 || campaignEntity.getEPC() != 0 || campaignEntity.getCPC() != 0 ||
                                campaignEntity.getRev() != 0 || campaignEntity.getSpend() != 0 || campaignEntity.getLpCl() != 0 ||
                                campaignEntity.getCurrentCpc() != 0) {
                            tempEntity = MySQLDaoImpl.getInstance().getCampaignEntity(campaignEntity.getTrackerId(),
                                    campaignEntity.getCampaignId(), campaignEntity.getDate());
                            if (tempEntity != null) {
                                campaignEntity.setId(tempEntity.getId());
                                MySQLDaoImpl.getInstance().updateCampagnEntuty(campaignEntity);
                                tempEntity = null;
                            } else MySQLDaoImpl.getInstance().addCampaignEntity(campaignEntity);
                        }
                    }
                }
            }
        }
        MySQLDaoImpl.getSessionFactory().close();
    }
}
