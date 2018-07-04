package online.omnia.statistics;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lollipop on 15.11.2017.
 */
public class CampaignsListJsonDeserializer implements JsonDeserializer<List<CampaignEntity>>{
    @Override
    public List<CampaignEntity> deserialize(JsonElement jsonElement, Type type,
                                            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray array = jsonElement.getAsJsonArray();
        List<CampaignEntity> campaignEntities = new ArrayList<>();
        CampaignEntity entity;
        for (JsonElement element : array) {
            System.out.println(element);
            entity = new CampaignEntity();
            entity.setCampaignId(element.getAsJsonObject().get("id").getAsInt());
            //entity.setDate();
            entity.setStatus(element.getAsJsonObject().get("status").getAsInt());
            entity.setName(element.getAsJsonObject().get("name").getAsString());
            if (element.getAsJsonObject().get("date_cr") != null)
            entity.setDateCR(new Date(element.getAsJsonObject().get("date_cr").getAsLong() * 1000));
            entity.setKeyword(element.getAsJsonObject().get("keyword").getAsString());
            entity.setGroupId(element.getAsJsonObject().get("group_id").getAsInt());
            entity.setGroupName(element.getAsJsonObject().get("group_name").getAsString());
            if (element.getAsJsonObject().get("ts") != null)
            entity.setTs(element.getAsJsonObject().get("ts").getAsString());
            entity.setTsId(element.getAsJsonObject().get("ts_id").getAsInt());
            entity.setStartDate(new Date(element.getAsJsonObject().get("start_date").getAsLong() * 1000));
            entity.setClicks(element.getAsJsonObject().get("clicks").getAsInt());
            entity.setBots(element.getAsJsonObject().get("bots").getAsInt());
            entity.setProfit(element.getAsJsonObject().get("profit").getAsDouble());
            if (element.getAsJsonObject().get("ROI") != null)
            entity.setROI(element.getAsJsonObject().get("ROI").getAsDouble());
            if (element.getAsJsonObject().get("LP_CTR") != null)
            entity.setLP_CTR(element.getAsJsonObject().get("LP_CTR").getAsDouble());
            entity.setLeads(element.getAsJsonObject().get("leads").getAsInt());
            if (element.getAsJsonObject().get("CR") != null)
            entity.setCR(element.getAsJsonObject().get("CR").getAsDouble());
            if (element.getAsJsonObject().get("EPC") != null)
            entity.setEPC(element.getAsJsonObject().get("EPC").getAsDouble());
            if (element.getAsJsonObject().get("CPC") != null)
            entity.setCPC(element.getAsJsonObject().get("CPC").getAsDouble());
            if (element.getAsJsonObject().get("rev") != null)
            entity.setRev(element.getAsJsonObject().get("rev").getAsDouble());
            entity.setSpend(element.getAsJsonObject().get("spend").getAsDouble());
            entity.setLpCl(element.getAsJsonObject().get("lp_cl").getAsInt());
            if (element.getAsJsonObject().get("off_cl") != null)
            entity.setOffCl(element.getAsJsonObject().get("off_cl").getAsInt());
            entity.setNote(element.getAsJsonObject().get("note").getAsString());
            entity.setCurrentCpc(element.getAsJsonObject().get("current_cpc").getAsDouble());
            entity.setAutoCpc(element.getAsJsonObject().get("auto_cpc").getAsInt());
            entity.setLink(element.getAsJsonObject().get("link").getAsString());
            campaignEntities.add(entity);
        }
        return campaignEntities;
    }
}
