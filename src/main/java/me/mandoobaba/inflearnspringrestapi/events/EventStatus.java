package me.mandoobaba.inflearnspringrestapi.events;

public enum EventStatus {

    DRAFT(0), PUBLISHED(1), BEGAN_ENROLLMENT(2);

    private Integer type;

    EventStatus(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }

    public static EventStatus getEventStatus(Integer type) {
        for(EventStatus es: EventStatus.values()) {
            if(es.getType() == type) {
                return es;
            }
        }
        return null;
    }


}
