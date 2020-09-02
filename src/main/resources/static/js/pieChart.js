var chartDatastr = decodeHTML(chartData);
var chartJSONArr = JSON.parse(chartDatastr);

var arrayLength = chartJSONArr.length;
var numericData = [];
var labelData = [];

for(var i = 0 ; i < arrayLength; i++){
	numericData[i] = chartJSONArr[i].value;
	labelData[i] = chartJSONArr[i].label;
}



new Chart(document.getElementById("myPieChart"),{
	type: 'pie',
	data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            
            backgroundColor: ["#355070","#B56576","#EAAC8B","#74226C","#4B2142","#8CACB3","#878DA4"],
           // borderColor: '#FFFFFF',
            data: numericData
        }]
    },

    options: {
    	title:{
    		display : true,
    		text : 'project statuses'
    	}
    	
    }
});
//[{"value":1,"label":"COMPLETED"},{"value":2,"label":"INPROGRESS"},{"value":1,"label":"NOTSTARTED"}]
function decodeHTML(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}