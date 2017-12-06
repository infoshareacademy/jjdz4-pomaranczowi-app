package com.infoshareacademy.pomaranczowi.financialanalyser.utilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ImportCurrentDataTest {

    @Mock
    FileReader fileReader = new FileReader("cli/config.json");

    public ImportCurrentDataTest() throws FileNotFoundException {
    }

    @Test
    public void downloadFileFromURL() {
    }

    @Test
    public void getDataDirectoryDestination() {
        //given
        try {
            when(new FileReader("cli/config")).thenReturn(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //when
        ImportCurrentData.downloadFileFromURL();
        String dataDestination = ImportCurrentData.getDataDirectoryDestination();
        //then
        assertThat(dataDestination).isEqualTo("cli/data/stock_data/");
    }

    @Test
    public void getFundListDestination() {
    }
}