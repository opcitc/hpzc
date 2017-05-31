package com.hpzc.common.util;

/**
 * 加密工具类
 * 
 * @author 李广
 * @date 2016-5-4
 */
public class EncryptUtil {
	/**定义字符密码串*/
	//private static final char[] COPASSWORD = " \"#$%&()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
	//private static final char[] COPASSWORD = "\"#$%&()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~'!".toCharArray();
	private static final char[] COPASSWORD = " !\"#$%&()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();	
	/**字符密码串长度为94*/
	private static final int COPASSWORDNUM = 94;
	
	/**加密字符串的最大长度为32位*/
	private static final int COPASSWORDLENGTH = 32;
	
	/**加密秘钥*/
	private static final String DEF_COKEY="Wz=M?LrU&N\\`E!@mBb K/n)e;SvR+Da[";
	
	
	public static String encryp(String plaintext){
		/**当前协定好的秘钥为YES*/
		return encryp(plaintext, DEF_COKEY);
	}
	
	/**
	 * 对输入的字符串进行加密
	 * @param plaintext
	 * @param key
	 * @return
	 */
	public static String encryp(String plaintext,String key){
		
		//System.out.println("加密开始....");
		if(plaintext == null || plaintext.equals("") || plaintext.length() > COPASSWORDLENGTH){
			throw new RuntimeException("加密的字符串不能为空且长度需要小于等于32位");
		}
		if(key == null || key.equals("") || key.length() > COPASSWORDLENGTH){
			throw new RuntimeException("秘钥字符串不能为空且长度需要小于等于32位");
		}
		int lnumber;
		int lkeyval;
		int lplainval;
		int l_accumulate = 0;
		char[] plainchars = toChararry(plaintext,COPASSWORDLENGTH);
		char[] keychars = toChararry(key,COPASSWORDLENGTH);
		char[] copasswordchars = COPASSWORD;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < COPASSWORDLENGTH; i++) {
			char plainchar = plainchars[i];
			char keychar = keychars[i];
			lplainval = getPlaintextOrKeyVal(COPASSWORD,plainchar);
			lkeyval = getPlaintextOrKeyVal(COPASSWORD,keychar);
			lnumber = (lplainval + lkeyval + l_accumulate)%COPASSWORDNUM;
			sb.append(copasswordchars[lnumber]);
			l_accumulate = l_accumulate + lplainval;
		}
		
		//System.out.println("加密结束....");
		return sb.toString();
		
		
		
	}
	
	
	/**
	 * 查找给定字符在COPASSWORD中的位置。位置从0开始
	 * @param imcopassword
	 * @param perPlaintKeyVal  明文的每个字符
	 * @return
	 */
	private static int getPlaintextOrKeyVal(char[] imcopassword,char perPlaintKeyVal){
		int chpos = -1;
		char[] imchars = imcopassword;
		for (int i = 0; i < imchars.length; i++) {
			if(imchars[i] == perPlaintKeyVal){
				chpos=i;
				break;
			}
		}
		return chpos;
	}
	
	/**对给定的字符串转为一个定长的字符数组。如果字符串长度小于给定长度，则用空格补足*/
	private static char[] toChararry(String str,int arrylength){
		if(str == null || str.equals("")){
			throw new RuntimeException("给定的字符串不能为空");
		}
		if(arrylength <=0 ){
			throw new RuntimeException("定长不能小于等于0");
		}
		char[] strcharsadd = new char[arrylength];
		char[] strchars = str.toCharArray();
		int strcharslength = strchars.length;
		if(strchars.length <= arrylength){
			for(int i=0;i<arrylength;i++){
				if(i < strcharslength){
					strcharsadd[i] = strchars[i];
				}else{
					strcharsadd[i]=" ".charAt(0);
				}
			}
		}else{
			throw new RuntimeException("给定长度不能小于字符串的长度。字符长度：" + strchars.length + " 给定长度为：" + arrylength);
		}
		return strcharsadd;
	}
	
	 
	
	public static void main(String[] args) {
//		char[] zchars = Vigenere.toChararry("Wz=M?LrU&N\\`E!@mBb K/n)e;SvR+Da[", 32);
//		for (int i = 0; i < zchars.length; i++) {
//			System.out.println(zchars[i]);
//		}
		
//		int ccpos = Vigenere.getPlaintextOrKeyVal(COPASSWORD, "#".charAt(0));
//		System.out.println(ccpos);
		System.out.println(COPASSWORD.length);
		String dd =encryp("RMB",DEF_COKEY);
		System.out.println("RMB:" + dd);
		
		 
		dd =encryp("1",DEF_COKEY);
		System.out.println("1:" + dd);
		
		dd =encryp("2",DEF_COKEY);
		System.out.println("2:" + dd);
		
		dd =encryp("01",DEF_COKEY);
		System.out.println("01:" + dd);
		
		dd =encryp("02",DEF_COKEY);
		System.out.println("02:" + dd);
		
		dd =encryp("3000",DEF_COKEY);
		System.out.println("3000:" + dd);
		
	}
}
