package entity;

public class SectionInfo implements Comparable<SectionInfo> {
	public String courseName;
	public String buliding;
	public String classroom;
	public int week;
	public int lession;
	public String time;
	public String stuNum;

	@Override
	/**
	 * 按上课时间排序
	 */
	public int compareTo(SectionInfo o) {
		if (week != o.week) {
			return week - o.week;
		} else {
			return lession - o.lession;
		}
	}

}