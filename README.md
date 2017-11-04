Financial Analyser (Analizator Finansowy)
=========================================

Basic tool for currencies and stock data analysis.

## Features

- Finding global and local extremes of currency/stock quotations
- Finding quotations for demanded date
- Showing statistics for year, month, week etc.
- Works on static data or on data downloaded from a link specified in JSON configuration file (only for stock quotations)

## Configuration

You can configure application using config.json file.

To set a link the zipped stock data is downloaded from, change: 
```
"url": "http://bossa.pl/pub/fundinwest/omega/omegafun.zip",
```

To set an output directory for the downloaded zip file, change:
```
"zipDestination": "data/stock_data.zip"
```

To set an output directory for the data extracted from downladed zip, change:
```
"dataDirectoryDestination": "data/stock_data/"
```

To set a link which the list of files containted in zip is downloaded from, change:
```
"fundListURL": "httap://bossa.pl/pub/fundinwest/omega/omegafun.lst"
```

To set output directory for downloaded list, change:
```
"fundListDestination": "data/omegafun.lst"
```

**Please note that all output paths must start from the application root directory and end with "/" when it's path to a directory.**


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back

## Authors

* **Dawid Śremski** - [dawidsremski](https://github.com/dawidsremski)
* **Mateusz Sosnowski** - [mathiaspine](https://github.com/mathiaspine)
* **Mateusz Zalewski** - [matzal](https://github.com/matzal)
* **Tomasz Okoniewski** - [tomekokoniewski](https://github.com/tomekokoniewski)

See also the list of [contributors](https://github.com/infoshareacademy/jjdz4-pomaranczowi-app/contributors) who participated in this project.
