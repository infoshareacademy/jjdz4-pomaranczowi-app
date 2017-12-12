package com.infoshareacademy.pomaranczowi.financialanalyser.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ImportCurrentDataTest {

    @Test
    public void downloadFileFromURL() {
    }

    @Test
    public void getDataDirectoryDestinationTest() {
        //given
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile("config.json");
        //when
        String dataDestination = ImportCurrentData.getDataDirectoryDestination();
        //then
        assertThat(dataDestination).isEqualTo("cli/data/stock_data/");
    }

    @Test
    public void getFundListDestinationTest() {
        //given
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile("config.json");
        //when
        String dataDestination = ImportCurrentData.getFundListDestination();
        //then
        assertThat(dataDestination).isEqualTo("cli/data/omegafun.lst");
    }

    @Test
    public void readJsonConfigFile() {
    }

    @Test
    public void extractAllFromZipFileTest() throws IOException {
        //given
        String source = "data/stock_data.zip";
        String destination = "data/stock_data/";
        File directory = new File(destination);
        //when
        FileUtils.deleteDirectory(directory);
        ImportCurrentData.extractAllFromZipFile(source, destination);
        //then
        assertThat(directory).exists();
    }
}