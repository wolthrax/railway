package railway.dba.enums;

public enum ColumnNames {
	
	USER_ID("id"), 
	USER_LOGIN("login"), 
	USER_PASSWORD("password"),
	USER_NAME("name"),
	USER_SURNAME("surname"),
	USER_EMAIL("email"),
	USER_PHONE("phone"),
	USER_MONEY("money"),
	USER_ROLE("role"),
	
	TICKET_USER_ID("user_id"),
	TICKET_TRAIN_ID("train_id"),
	TICKET_PLACE("place"),
	
	TRAIN_ID("id"),
	TRAIN_PLACES("places"),
	TRAIN_PRICE("price"),
	TRAIN_SCHEDULE_ID("schedule_id"),
	
	SCHEDULE_ID("id"),
	SCHEDULE_DEPATURE_TIME("depature_time"),
	SCHEDULE_ARRIVAL_TIME("arrival_time"),
	SCHEDULE_DEPATURE_STATION("depature_station"),
	SCHEDULE_ARRIVAL_STATION("arrival_station"),
	
	STATION_ID("id"),
	STATION_NAME("name");
	
	private String columnName;
	
	private ColumnNames(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
