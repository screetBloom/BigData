package com.screetbloom.bigData;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;



public class up {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		Configuration conf =new Configuration(); 
		conf.set("fs.default.name", "hdfs://115.159.216.136:9000");
		FileSystem fs=FileSystem.get(new URI("hdfs://115.159.216.136:9000"),conf);
		fs.copyFromLocalFile(new Path("e:\\testData\\water_new.txt"), new Path("hdfs://115.159.216.136:9000/water_new.txt"));
        fs.close();
	}

}
