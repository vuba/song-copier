package com.vuba.songfinder.configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ConfiguratorReaderTest {

    private final ConfiguratorReader configuratorReader = new ConfiguratorReader();

    @Test
    void readConfigSafely() {
        var inputConfiguration = configuratorReader.readConfigSafely();
        var expectedConfiguration = ConfiguratorReaderSetUp.expectedConfiguration();
        Assertions.assertThat(inputConfiguration).isEqualTo(expectedConfiguration);
    }
}