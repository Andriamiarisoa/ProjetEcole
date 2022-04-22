/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

/**
 *
 * @author YASSER
 */
import java.util.Vector;
import java.lang.reflect.*;

public class GeneralisedFunction {

	public static String upperFirstChar(String word){
		String first=word.substring(0,1);
		String next=word.substring(1);
		first=first.toUpperCase();
		return first+next;
	}

	public static Method[] getAccessors(Object o,String type){
		Class cl=o.getClass();
		Method[] mthds=cl.getDeclaredMethods();
		String[] text=new String[getAccessibleFields(o,type).length];
		int same=0;

		for (int n=0;n<getAccessibleFields(o,type).length;n++){
        	text[n]=getAccessibleFields(o,type)[n];
        	text[n]=upperFirstChar(text[n]);
        	text[n]=type+text[n];
        }
        for (int i=0;i<text.length ;i++ ) {
        	for (int j=0;j<mthds.length ;j++ ) {
        		if (text[i].compareTo(mthds[j].getName())==0) {
        			same++;
        		}
        	}
        }
        Method[] mthds2=new Method[same];
        int same1=same;
        while(same>0){        
        	for (int i=0;i<text.length ;i++ ) {
	        	for (int j=0;j<mthds.length ;j++ ) {
	        		if (text[i].compareTo(mthds[j].getName())==0) {
	        			mthds2[same1-same]=mthds[j];
	        			same --;
	        		}
	        	} 
        	}
    	}
            return mthds2;
	}

	public static Vector getValues(Object o){
		Method[] meth=getAccessors(o,"get");
		Vector vect=new Vector();
		for (int n=0;n<meth.length;n++){
			try{
				if (meth[n].invoke(o)!=null){
					vect.add(meth[n].invoke(o));
				}else{
					vect.add("");
				}
			}catch (Exception e) {
				continue;
			}
			
		}
		return vect;
	}
	public static String[] getAccessibleFields(Object o,String type){
		Class cl=o.getClass();
		Method[] mthds=cl.getDeclaredMethods();
		String[] text=new String[cl.getDeclaredFields().length];
		String[] text1=new String[cl.getDeclaredFields().length];
		int same=0;
		for (int n=0;n<cl.getDeclaredFields().length;n++){
        	text[n]=cl.getDeclaredFields()[n].getName();
        	text[n]=upperFirstChar(text[n]);
        	text[n]=type+text[n];
        }
        for (int n=0;n<cl.getDeclaredFields().length;n++){
        	text1[n]=cl.getDeclaredFields()[n].getName();
        }
        for (int i=0;i<text.length ;i++ ) {
        	for (int j=0;j<mthds.length ;j++ ) {
        		if (text[i].compareTo(mthds[j].getName())==0) {
        			same++;
        		}
        	}
        }
        String[] result=new String[same];
        int same1=same;
        while(same>0){        
        	for (int i=0;i<text.length ;i++ ) {
	        	for (int j=0;j<mthds.length ;j++ ) {
	        		if (text[i].compareTo(mthds[j].getName())==0) {
	        			result[same1-same]=text1[i];
	        			same --;
	        		}
	        	}
        	}
    	}
        return result;
	}
}
