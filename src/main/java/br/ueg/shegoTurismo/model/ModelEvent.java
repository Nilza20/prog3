package br.ueg.shegoTurismo.model;

import java.util.Objects;

public class ModelEvent {
	
	private Long eventId;
    private String eventType;
    
    public ModelEvent() { }

    public ModelEvent(Long eventId, String eventType) {
        this.eventId = eventId;
        this.eventType = eventType;
    }
    
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelEvent)) return false;
        ModelEvent that = (ModelEvent) o;
        return Objects.equals(eventId, that.eventId) &&
                Objects.equals(eventType, that.eventType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventType);
    }

    @Override
    public String toString() {
        return "AtracaoEvent{" +
                "eventId=" + eventId +
                ", eventType='" + eventType + '\'' +
                '}';
    }

}
