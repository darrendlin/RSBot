package com.loneleh.util.helper;

import java.util.concurrent.TimeUnit;

public class Time
{
	public static String format(long milli)
	{
		final long hr = TimeUnit.MILLISECONDS.toHours(milli);
        final long min = TimeUnit.MILLISECONDS.toMinutes(milli - TimeUnit.HOURS.toMillis(hr));
        final long sec = TimeUnit.MILLISECONDS.toSeconds(milli - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min));
        //final long ms = TimeUnit.MILLISECONDS.toMillis(milli - TimeUnit.HOURS.toMillis(hr) - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec));
        return String.format("%02d:%02d:%02d", hr, min, sec);
        //return String.format("%02d:%02d:%02d.%03d", hr, min, sec, ms);
	}
}
