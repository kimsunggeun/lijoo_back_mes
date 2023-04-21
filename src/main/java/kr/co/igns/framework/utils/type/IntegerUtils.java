package kr.co.igns.framework.utils.type;

public class IntegerUtils {
	public static int getNullInt(Object obj) {
		int result = 0;
		if (obj != null) {
			String rst = String.valueOf(obj);
			result = Integer.valueOf(rst);
		}

		return result;
	}

	public static String getNullStr(Object obj) {
		String result = "";
		if (obj != null) {
			result = String.valueOf(obj);
		}

		return result;
	}

	//숫자형식을 한글로 변환
	public static String convertIntToKorean(String strNum) {

	    String[] han1 = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
	    String[] han2 = { "", "십", "백", "천" };
	    String[] han3 = { "", "만", "억", "조", "경" };
	    String result = "";
	    int len = strNum.length();
	    int nowInt = 0;
	    boolean hasHan3 = false;
	    for (int i = len; i > 0; i--) {
	      nowInt = Integer.parseInt(strNum.substring(len - i, len - i + 1));
	      int han2Pick = (i - 1) % 4;
	      if (nowInt > 0) {
	        result += (han1[nowInt]) + (han2[han2Pick]);
	        if (han2Pick > 0) {
	          hasHan3 = false;
	        }
	      }
	      if (!hasHan3 && han2Pick == 0) {
	        result += (han3[(i - 1) / 4]);
	        hasHan3 = true;
	      }
	    }
	    return result.toString();
		
	}
	
}