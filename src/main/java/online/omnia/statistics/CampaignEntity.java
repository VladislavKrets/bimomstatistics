package online.omnia.statistics;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lollipop on 14.11.2017.
 */
@Entity
@Table(name = "campaigns_tracker")
public class CampaignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "campaign_id")
    private int campaignId;
    @Column(name = "date")
    private Date date;
    @Column(name = "prefix")
    private int trackerId;
    @Column(name = "status")
    private int status;
    @Column(name = "name")
    private String name;
    @Column(name = "date_cr")
    private Date dateCR;
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "group_id")
    private int groupId;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "ts")
    private String ts;
    @Column(name = "ts_id")
    private int tsId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "clicks")
    private int clicks;
    @Column(name = "bots")
    private int bots;
    @Column(name = "profit")
    private double profit;
    @Column(name = "ROI")
    private double ROI;
    @Column(name = "LP_CTR")
    private double LP_CTR;
    @Column(name = "leads")
    private int leads;
    @Column(name = "CR")
    private double CR;
    @Column(name = "EPC")
    private double EPC;
    @Column(name = "CPC")
    private double CPC;
    @Column(name = "rev")
    private double rev;
    @Column(name = "spend")
    private double spend;
    @Column(name = "lp_cl")
    private int lpCl;
    @Column(name = "off_cl")
    private int offCl;
    @Column(name = "note")
    private String note;
    @Column(name = "current_cpc")
    private double currentCpc;
    @Column(name = "auto_cpc")
    private int autoCpc;
    @Column(name = "link")
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCR() {
        return dateCR;
    }

    public void setDateCR(Date dateCR) {
        this.dateCR = dateCR;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getBots() {
        return bots;
    }

    public void setBots(int bots) {
        this.bots = bots;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getROI() {
        return ROI;
    }

    public void setROI(double ROI) {
        this.ROI = ROI;
    }

    public double getLP_CTR() {
        return LP_CTR;
    }

    public void setLP_CTR(double LP_CTR) {
        this.LP_CTR = LP_CTR;
    }

    public int getLeads() {
        return leads;
    }

    public void setLeads(int leads) {
        this.leads = leads;
    }

    public double getCR() {
        return CR;
    }

    public void setCR(double CR) {
        this.CR = CR;
    }

    public double getEPC() {
        return EPC;
    }

    public void setEPC(double EPC) {
        this.EPC = EPC;
    }

    public double getCPC() {
        return CPC;
    }

    public void setCPC(double CPC) {
        this.CPC = CPC;
    }

    public double getRev() {
        return rev;
    }

    public void setRev(double rev) {
        this.rev = rev;
    }

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    public int getLpCl() {
        return lpCl;
    }

    public void setLpCl(int lpCl) {
        this.lpCl = lpCl;
    }

    public int getOffCl() {
        return offCl;
    }

    public void setOffCl(int offCl) {
        this.offCl = offCl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getCurrentCpc() {
        return currentCpc;
    }

    public void setCurrentCpc(double currentCpc) {
        this.currentCpc = currentCpc;
    }

    public int getAutoCpc() {
        return autoCpc;
    }

    public void setAutoCpc(int autoCpc) {
        this.autoCpc = autoCpc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "CampaignEntity{" +
                "id=" + id +
                ", campaignId=" + campaignId +
                ", date=" + date +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", dateCR=" + dateCR +
                ", keyword='" + keyword + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", ts='" + ts + '\'' +
                ", tsId=" + tsId +
                ", startDate=" + startDate +
                ", clicks=" + clicks +
                ", bots=" + bots +
                ", profit=" + profit +
                ", ROI=" + ROI +
                ", LP_CTR=" + LP_CTR +
                ", leads=" + leads +
                ", CR=" + CR +
                ", EPC=" + EPC +
                ", CPC=" + CPC +
                ", rev=" + rev +
                ", spend=" + spend +
                ", lpCl=" + lpCl +
                ", offCl=" + offCl +
                ", note='" + note + '\'' +
                ", currentCpc=" + currentCpc +
                ", autoCpc=" + autoCpc +
                ", link='" + link + '\'' +
                '}';
    }

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }
}
