package com.hpzc.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeqNum {

	// private static int sequence = 2;
	//
	// private static int length = 3;

	/**
	 * YYYYMMDD+6位自增长码(20位)
	 * 
	 * @author zhengguohui
	 * @return
	 */
	public synchronized String getSeqNum(int sequence, int length, String flag) {
		sequence = sequence >= 999999 ? 1 : sequence + 1;
		String datetime = new SimpleDateFormat("yyyyMM").format(new Date());
		String s = Integer.toString(sequence);
		System.out.println(s);
		return flag + datetime + addLeftZero(s, length);
	}

	/**
	 * 左填0
	 * 
	 * @author zhengguohui
	 * @param s
	 * @param length
	 * @return
	 */
	public static String addLeftZero(String s, int length) {
		int old = s.length();
		if (length > old) {
			char[] c = new char[length];
			char[] x = s.toCharArray();
			if (x.length > length) {
				throw new IllegalArgumentException(
						"Numeric value is larger than intended length: " + s + " LEN " + length);
			}
			int lim = c.length - x.length;
			for (int i = 0; i < lim; i++) {
				c[i] = '0';
			}
			System.arraycopy(x, 0, c, lim, x.length);
			return new String(c);
		}
		return s.substring(0, length);

	}

}
