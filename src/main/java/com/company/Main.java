package com.company;

import org.apache.hadoop.yarn.client.api.*;
import org.apache.hadoop.yarn.api.records.*;
import org.apache.hadoop.yarn.conf.*;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Main {

    public static final String RESOURCEMANAGER_URL = "hadoopmaster01.stg.ps:8032";

    public static void main(String[] args) throws Exception {
        YarnClient client = YarnClient.createYarnClient();
        YarnConfiguration conf = new YarnConfiguration();
        conf.set("yarn.resourcemanager.address", RESOURCEMANAGER_URL);
        client.init(conf);

        System.out.println("Connecting to Yarn on " + RESOURCEMANAGER_URL + " ...");
        client.start();

        System.out.println(client.getYarnClusterMetrics().getNumNodeManagers() + " node managers");
        for (NodeReport state : client.getNodeReports()) {
            System.out.println(state);
        }
        System.out.println("========================================");
        for (QueueInfo queueInfo : client.getAllQueues()) {
            System.out.println(queueInfo);
        }
        System.out.println("========================================");
        System.out.println("10 first applications:");
        for (ApplicationReport appReport : client.getApplications().subList(0, 10)) {
            System.out.println(appReport.getApplicationId().getId() + " " + appReport.getName());
            ApplicationAttemptReport rr = client.getApplicationAttemptReport(appReport.getCurrentApplicationAttemptId());
            System.out.println("attempt: " + rr.getApplicationAttemptId());
        }
    }
}

