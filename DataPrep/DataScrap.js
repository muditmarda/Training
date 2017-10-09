
var Arr = document.getElementsByClassName('MsoPlainText');
var button = document.getElementById('downloadCSVbutton');
var data = [[]];
data[0] = ['DEPARTMENT', 'CODE', 'DESCRIPTION', 'RATE'];
var dept, code, desc, rate, parts, temp, last;
var re = /DEPARTMENT OF/;
var re1 = /\S+\s+\S+\s+\d+/;
var re2 = /\s+\S+\s+DEPARTMENT OF NEUROLOGY/;
var re3 = /\s*/;

for(var i = 0; i < Arr.length; i++){
	if(Arr[i].innerText == "ACCOMMODATION CHARGES W.E.F. 01.09.2006"){
		break;	
	}
	else if(re2.test(Arr[i].innerText)){
		dept = "NEUROLOGY";
	}
	else if(re.test(Arr[i].innerText)){
		dept = Arr[i].innerText.slice(14, Arr[i].innerText.length);
	}
	else if(re1.test(Arr[i].innerText)){
		parts = Arr[i].innerText.split(" ");
		last = parts.length - 1;
		code = parts[0].replace(/\s/g,'');
		rate = parts[last].replace(/\s/g,'');
		if(rate.length <= 0){
			last = parts.length - 2;
			rate = parts[last].replace(/\s/g,'');
		}
		desc = '';

		for (var j = 1; j < last; j++){
			temp = parts[j].replace(/\s/g,'');
			desc += temp;
			desc += " ";
		}
		desc = desc.substring(0,desc.length - 2);
		data.push([dept, code, desc, rate]);
	}
}

button.onclick = function(){
	var csvContent = "data:text/csv;charset=utf-8,";
	data.forEach(function(infoArray, index){
	   dataString = infoArray.join("|");
	   csvContent += index < data.length ? dataString+ "\n" : dataString;
	}); 
	var encodedUri = encodeURI(csvContent);
	var link = document.createElement("a");
	link.setAttribute("href", encodedUri);
	link.setAttribute("download", "my_data.csv");
	document.body.appendChild(link); // Required for FF
	link.click();
}