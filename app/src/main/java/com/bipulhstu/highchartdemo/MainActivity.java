package com.bipulhstu.highchartdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.highsoft.highcharts.common.hichartsclasses.HICondition;
import com.highsoft.highcharts.common.hichartsclasses.HIDataLabels;
import com.highsoft.highcharts.common.hichartsclasses.HILabel;
import com.highsoft.highcharts.common.hichartsclasses.HILegend;
import com.highsoft.highcharts.common.hichartsclasses.HILine;
import com.highsoft.highcharts.common.hichartsclasses.HINetworkgraph;
import com.highsoft.highcharts.common.hichartsclasses.HIOptions;
import com.highsoft.highcharts.common.hichartsclasses.HIPlotOptions;
import com.highsoft.highcharts.common.hichartsclasses.HIResponsive;
import com.highsoft.highcharts.common.hichartsclasses.HIRules;
import com.highsoft.highcharts.common.hichartsclasses.HISeries;
import com.highsoft.highcharts.common.hichartsclasses.HISubtitle;
import com.highsoft.highcharts.common.hichartsclasses.HITitle;
import com.highsoft.highcharts.common.hichartsclasses.HIYAxis;
import com.highsoft.highcharts.core.HIChartView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HINetworkgraph networkgraph = new HINetworkgraph();
//        ArrayList<HIDataLabels> dataLabelsList = new ArrayList<>();
//        HIDataLabels dataLabels = new HIDataLabels();
//        dataLabels.setEnabled(true);
//        networkgraph.setDataLabels(dataLabelsList);
//        options.setSeries(new ArrayList<>(Collections.singletonList(networkgraph)));


        HIChartView chartView = findViewById(R.id.hc);
        chartView.theme = "grid-light";

        HIOptions options = new HIOptions();

        HITitle title = new HITitle();
        title.setText("Solar Employment Growth by Sector, 2010-2016");
        options.setTitle(title);

        HISubtitle subtitle = new HISubtitle();
        subtitle.setText("Source: thesolarfoundation.com");
        options.setSubtitle(subtitle);

        HIYAxis yaxis = new HIYAxis();
        yaxis.setTitle(new HITitle());
        yaxis.getTitle().setText("Number of Employees");
        options.setYAxis(new ArrayList<>(Collections.singletonList(yaxis)));

        HILegend legend = new HILegend();
        legend.setLayout("vertical");
        legend.setAlign("right");
        legend.setVerticalAlign("middle");
        options.setLegend(legend);

        HIPlotOptions plotoptions = new HIPlotOptions();
        plotoptions.setSeries(new HISeries());
        plotoptions.getSeries().setLabel(new HILabel());
        plotoptions.getSeries().getLabel().setConnectorAllowed(false);
        plotoptions.getSeries().setPointStart(2010);
        options.setPlotOptions(plotoptions);

        HILine line1 = new HILine();
        line1.setName("Installation");
        line1.setData(new ArrayList<>(Arrays.asList(43934, 52503, 57177, 69658, 97031, 0, 137133, 154175)));

        HILine line2 = new HILine();
        line2.setName("Manufacturing");
        line2.setData(new ArrayList<>(Arrays.asList(24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434)));

        HILine line3 = new HILine();
        line3.setName("Sales & Distribution");
        line3.setData(new ArrayList<>(Arrays.asList(11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387)));

        HILine line4 = new HILine();
        line4.setName("Project Development");
        line4.setData(new ArrayList<>(Arrays.asList(null, null, 7988, 12169, 15112, 22452, 34400, 34227)));

        HILine line5 = new HILine();
        line5.setName("Other");
        line5.setData(new ArrayList<>(Arrays.asList(12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111)));

        HIResponsive responsive = new HIResponsive();

        HIRules rules1 = new HIRules();
        rules1.setCondition(new HICondition());
        rules1.getCondition().setMaxWidth(500);
        HashMap<String, HashMap> chartLegend = new HashMap<>();
        HashMap<String, String> legendOptions = new HashMap<>();
        legendOptions.put("layout", "horizontal");
        legendOptions.put("align", "center");
        legendOptions.put("verticalAlign", "bottom");
        chartLegend.put("legend", legendOptions);
        rules1.setChartOptions(chartLegend);
        responsive.setRules(new ArrayList<>(Collections.singletonList(rules1)));
        options.setResponsive(responsive);

        options.setSeries(new ArrayList<>(Arrays.asList(line1, line2, line3, line4, line5)));

        chartView.setOptions(options);
    }
}