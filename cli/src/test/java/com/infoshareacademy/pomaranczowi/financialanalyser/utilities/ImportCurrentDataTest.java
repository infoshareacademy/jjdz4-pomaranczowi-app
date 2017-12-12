package com.infoshareacademy.pomaranczowi.financialanalyser.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


public class ImportCurrentDataTest {

/*    @Test
    public void downloadFileFromURLIT() throws IOException {
        //given
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile("config.json");
        new File("cli/").mkdir();
        //when
        ImportCurrentData.downloadFileFromURL(readJsonConfig);
        //then
        assertThat(new File("cli/data/stock_data/")).exists();
        FileUtils.deleteDirectory(new File("cli"));
    }*/

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
    public void readJsonConfigFileTest_dataDirectoryDestinaation() {
        //given
        String path = "config.json";
        //when
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile(path);
        //then
        assertThat(readJsonConfig.getDataDirectoryDestination()).isEqualTo("cli/data/stock_data/");
    }

    @Test
    public void readJsonConfigFileTest_fundListDestinaation() {
        //given
        String path = "config.json";
        //when
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile(path);
        //then
        assertThat(readJsonConfig.getFundListDestination()).isEqualTo("cli/data/omegafun.lst");
    }

    @Test
    public void readJsonConfigFileTest_fundListURL() {
        //given
        String path = "config.json";
        //when
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile(path);
        //then
        assertThat(readJsonConfig.getFundListURL()).isEqualTo("http://bossa.pl/pub/fundinwest/omega/omegafun.lst");
    }

    @Test
    public void readJsonConfigFileTest_URL() {
        //given
        String path = "config.json";
        //when
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile(path);
        //then
        assertThat(readJsonConfig.getUrl()).isEqualTo("http://bossa.pl/pub/fundinwest/omega/omegafun.zip");
    }

    @Test
    public void readJsonConfigFileTest_zipDestination() {
        //given
        String path = "config.json";
        //when
        ReadJsonConfig readJsonConfig = ImportCurrentData.readJsonConfigFile(path);
        //then
        assertThat(readJsonConfig.getZipDestination()).isEqualTo("cli/data/stock_data.zip");
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