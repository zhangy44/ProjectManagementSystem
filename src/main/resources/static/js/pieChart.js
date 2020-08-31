

new Chart(document.getElementById("myPieChart"),{
	type: 'pie',
	data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [{
            label: 'My First dataset',
            
            backgroundColor: ["#97EAD2","#8CC7A1","#816E94","#74226C","#4B2142","#8CACB3","#878DA4"],
            borderColor: '#4B2142',
            data: [0, 10, 5, 2, 20, 30, 45]
        }]
    },

    options: {}
});