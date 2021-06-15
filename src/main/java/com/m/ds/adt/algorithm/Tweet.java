package com.m.ds.adt.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author mukesh.kumar
 *
 */
public class Tweet {

	public static void main(String[] args) {

		String[] tweets = { "", "", "" };
		processTweets(tweets);
	}

	private static void processTweets(String[] tweets) {

		List<String> tweetList = Arrays.asList(tweets);

		tweetList.stream().filter(tweet -> isNotBlank(tweet)).forEach(tweet -> {
			updateHashTagMap(tweet);
		});

	}

	private static void updateHashTagMap(String tweet) {
		// TODO Auto-generated method stub

	}

	private static boolean isNotBlank(String tweet) {
		// TODO Auto-generated method stub
		return false;
	}
}
