// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages': ['corechart', 'table']});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawBarChart);
google.charts.setOnLoadCallback(() => drawReport(getReportDataModel(2)));
google.charts.setOnLoadCallback(() => drawReport(getReportDataModel(3)));

function drawReport(dataModel) {
    drawChart(dataModel);
    drawTable(dataModel);
}


function drawChart(dataModel) {
    var dataTable = new google.visualization.DataTable(dataModel.model);

    // Set chart options
    let options = {
        'legend': 'left',
        'title': 'My Big Pie Chart',
        'is3D': true,
        'width': 600,
        'height': 300
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById(dataModel.id + '_chart'));
    chart.draw(dataTable, options);
}

function drawTable(dataModel) {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Name');
    data.addColumn('number', 'Salary');
    data.addColumn('boolean', 'Full Time Employee');
    data.addRows([
        ['Mike', {v: 10000, f: '$10,000'}, true],
        ['Jim', {v: 8000, f: '$8,000'}, false],
        ['Alice', {v: 12500, f: '$12,500'}, true],
        ['Bob', {v: 7000, f: '$7,000'}, true]
    ]);

    var table = new google.visualization.Table(document.getElementById(dataModel.id + '_table'));
    table.draw(data, {showRowNumber: true, width: "75%"});
}

function getReportDataModel(index) {
    let data = {};
    data.model = {
        "cols": [
            {"id": "", "label": "Topping", "pattern": "", "type": "string"},
            {"id": "", "label": "Slices", "pattern": "", "type": "number"}
        ],
        "rows": [
            {
                "c": [
                    {"v": "Mushrooms", "f": null},
                    {"v": 3, "f": null}
                ]
            },
            {"c": [{"v": "Onions", "f": null}, {"v": 1, "f": null}]},
            {"c": [{"v": "Olives", "f": null}, {"v": 1, "f": null}]},
            {"c": [{"v": "Zucchini", "f": null}, {"v": 1, "f": null}]},
            {"c": [{"v": "Pepperoni", "f": null}, {"v": 2, "f": null}]}
        ]
    };

    data.id = "r" + index;
    data.title = "Report Title";
    data.chart_title = "Chart Title R1";
    return data;
}

async function drawBarChart() {
    let jsonData = await getJson("http://localhost:8080/report1");
    let headers = jsonData.columnDefinitions.map(item => item.label);;
    let chartInfo = Object.values(jsonData.data);
    let data = google.visualization.arrayToDataTable([headers, ...chartInfo]);

    let options = {
        chart: {
            title: jsonData.title,
            subtitle: jsonData.subtitle,
        },
        'width': 600,
        'height': 300
    };

    let chart = new google.visualization.ColumnChart(document.getElementById('r1_chart'));
    chart.draw(data, options);
}

async function getJson(url) {
    const response = await fetch(url);
    const jsonData = await response.json();
    console.log("::: JSON_DATA ", jsonData);
    return jsonData;
}