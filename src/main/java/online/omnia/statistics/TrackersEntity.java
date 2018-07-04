package online.omnia.statistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lollipop on 16.11.2017.
 */
@Entity
@Table(name = "trackers")
public class TrackersEntity {
    @Id
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "domain")
    private String domain;
    @Column(name = "api_key")
    private String apiKey;

    public String getPrefix() {
        return prefix;
    }

    public String getDomain() {
        return domain;
    }

    public String getApiKey() {
        return apiKey;
    }
}
