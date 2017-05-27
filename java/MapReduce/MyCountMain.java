package com.screetbloom.MapReduce;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyCountMain {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.set("fs.default.name", "hdfs://115.159.216.136:9000");
		
		Job job=new Job(conf);
		job.setJarByClass(MyCountMain.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setMapperClass(MyCountMapper.class);
		job.setReducerClass(MyCountReduce.class);
		FileInputFormat.addInputPath(job, new Path(URI.create("hdfs://115.159.216.136:9000/water_new.txt")));
		FileOutputFormat.setOutputPath(job, new Path(URI.create("hdfs://115.159.216.136:9000/waterresult02")));
		System.exit(job.waitForCompletion(true)?0:1);
	}

}
