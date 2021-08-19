package com.wenance.Challenge.wenance.Challenge;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ContextConfiguration
@SpringBootTest
public class ScheduledTasksTest {
    @SpyBean
    ScheduledTasks tasks;

    @Test
    public void scheduleTaskTenSecondsETH() {
        await().atMost(Duration.TEN_SECONDS).untilAsserted(() -> {
            verify(tasks, atLeast(1)).scheduleTaskTenSecondsETH();
        });
    }

    @Test
    public void scheduleTaskTenSecondsBTC() {
        await().atMost(Duration.TEN_SECONDS).untilAsserted(() -> {
            verify(tasks, atLeast(1)).scheduleTaskTenSecondsBTC();
        });
    }
}
