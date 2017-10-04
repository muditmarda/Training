var tablesArr = JSON.parse(tables);
var itemsArr = JSON.parse(items);
var modal = document.getElementById('myModal');
var tables = document.getElementById('tableList');
var items = document.getElementById('items');

console.log(tables);

function setTables(){
	alert("hi");
	console.log("hi");
	var txt = '<table class="table table-hover"><thead><tr><th>Tables</th></tr></thead><tbody>';

	for (var i = 0; i < tablesArr.length; i++){
		txt += '<tr><th><div class = "row container col-lg-4 col-md-4"><div class = "col-lg-12 col-md-12"><h3>';
		txt += tablesArr[i].name;
		txt += '</h3></div><div class = "col-lg-4 col-md-4">Rs. ' ;
		txt += tablesArr[i].total_amount;
		txt += '</div><div class = "col-lg-8 col-md-8">Total Items: ' ;
		txt += tablesArr[i].total_items;
		txt += '</div></div></th></tr>';
		
		// new_div.addEventListener("dragover",allowDrop,false);	
		// new_div.addEventListener("drop",drop,false);
		// new_div.addEventListener("click",showBill,false);

		// new_div.id = tables[i].id;
		// new_div.name = tables[i].name;
		// new_div.total_items = tables[i].total_items;
		// new_div.total_amount = tables[i].total_amount;
		// new_div.items = tables[i].items;

		// tables.appendChild(new_div);
	}
	txt += '</tbody></table>';
	console.log(txt);
	tables.innerHTML = txt;
}

function setMenu(){
	var txt = "";
	for(var i = 0; i < itemsArr.length; i++){
	txt += '<div class = "col-lg-12 col-md-12"><h5>';
	txt += itemsArr[i].name;
	}

}

function myFunction() {
    // Declare variables
    var input, filter, ul, li, a, i;
    input = document.getElementById('tableSearch');
    filter = input.value.toUpperCase();
    ul = document.getElementById("tableList");
    li = ul.getElementsByTagName('li');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function dragstart_handler(ev) {
 console.log("dragStart");
 // Add the target element's id to the data transfer object
 ev.dataTransfer.setData("text/plain", ev.target.id);
}
