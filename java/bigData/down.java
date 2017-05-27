package com.screetbloom.bigData;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class down {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
		Configuration conf =new Configuration(); 
		conf.set("fs.default.name", "hdfs://115.159.216.136:9000");
		FileSystem fs=FileSystem.get(new URI("hdfs://115.159.216.136:9000"),conf);
		fs.copyToLocalFile(new Path("hdfs://115.159.216.136:9000/ceshi.txt"), new Path("e:\\ceShi55.txt"));
		fs.close();
	}

}
