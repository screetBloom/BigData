package com.screetbloom.MapReduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.map(key, value, context);
		//通过空格获取所有的name
		String[] names=value.toString().split("\t");
		for(int i=0;i<names.length;i++){
			context.write(new Text(names[i]), new IntWritable(1));
		}
		/**
		 * hello 1
		 * hadoop 1
		 * world 1
		 * lunce 1
		 * .....
		 */
	}
}
