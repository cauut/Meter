package com.ifisolution.util;



public interface Value {
	public static String FORMAT_DATE="yyyy-MM-dd HH:mm:ss.S";
	public static String FORMAT_DATE_ID="yyyyMMdd";
	public static enum VALUE_METER {CODE, NAME, STATUS, UNIT, METERTYPE, PCI, PCS, STARTDATE};
	public static enum MAPID_PULSE{moduleId, bucketTs, ts};
	public static enum MAPID_OBJECT{partnerId, bucketId, objectCode,startDate};
}
