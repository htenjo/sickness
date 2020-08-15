function getReport2DataModel() {
    let data = {};
    data.model = {
        "cols": [
            { "id": "", "label": "Topping", "pattern": "", "type": "string" },
            { "id": "", "label": "Slices", "pattern": "", "type": "number" }
        ],
        "rows": [
            { "c": [{ "v": "Mushrooms", "f": null }, { "v": 3, "f": null }] },
            { "c": [{ "v": "Onions", "f": null }, { "v": 1, "f": null }] },
            { "c": [{ "v": "Olives", "f": null }, { "v": 1, "f": null }] },
            { "c": [{ "v": "Zucchini", "f": null }, { "v": 1, "f": null }] },
            { "c": [{ "v": "Pepperoni", "f": null }, { "v": 2, "f": null }] }
        ]
    };

    data.id = "r2";
    data.title = "Report Title";
    data.chart_title = "Chart Title R2";
    return data;
}