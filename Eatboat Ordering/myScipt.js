var tablesArr = JSON.parse(tables);
var itemsArr = JSON.parse(items);
var modal = document.getElementById('myModal');
var tables = document.getElementById('tableList');
var items = document.getElementById('itemList');
var itemsOrdered = new Array(tablesArr.length);
for (var i = 0; i < tablesArr.length; i++){
	itemsOrdered[i] = Array.apply(null, Array(itemsArr.length)).map(Number.prototype.valueOf,0);
}
var usingTab_id;

function orderDetails(tab_id){
	tab_id = tab_id[3];
	tab_id = parseInt(tab_id);
	usingTab_id = tab_id;
	var head = document.getElementById("modal-header-content");
	var txt = '<h4>Table ';
	txt += tab_id + 1;
	txt += ' | Order Details</h4>'
	head.innerHTML = txt;
	var body = document.getElementById('modal-body');
	var sl_no = 1;
	txt = '<table class="table table-hover" id = "myTable"><thead><tr><th>Sl. No.</th><th>Item</th><th>Price</th><th>Servings</th><th></th></thead><tbody>';
	for(var i = 0; i < itemsOrdered[tab_id].length; i++){
		if (itemsOrdered[tab_id][i] === 0){
			continue;
		}
		txt += '<tr id = "';
		txt += tab_id;
		txt += i;
		txt += '"><td>';
		txt += sl_no;
		txt += '</td><td>';
		txt += itemsArr[i].name;
		txt += '</td><td>';
		txt += itemsArr[i].cost;
		txt += '</td><td><input id="servingsCount" type="number" value="'
		txt += itemsOrdered[tab_id][i];
		txt += '" onchange = "servingsChanged(this)"></td><td><img src = "deleteIcon.png" height = "15%" onclick="deleteRow(this)"></td></td>';
		sl_no++;
	}
	txt += '</tbody></table>';
	body.innerHTML = txt;
	console.log(txt);
	modal.style.display = "block";
}

function servingsChanged(r){
	var i = r.parentNode.parentNode.id[1];
    var servings = document.getElementById("servingsCount").value;
    console.log(itemsOrdered[usingTab_id][i] * itemsArr[i].cost);
	tablesArr[usingTab_id].total_amount -= itemsOrdered[usingTab_id][i] * itemsArr[i].cost  ;
	tablesArr[usingTab_id].total_items -= itemsOrdered[usingTab_id][i];
	itemsOrdered[usingTab_id][i] = parseInt(servings); 
	// console.log(servings);
	tablesArr[usingTab_id].total_amount += itemsOrdered[usingTab_id][i] * itemsArr[i].cost;
    tablesArr[usingTab_id].total_items += itemsOrdered[usingTab_id][i];
    setTables();
    
}

function deleteRow(r) {
	var i = r.parentNode.parentNode.id[1];
    var j = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(j);
   	itemsOrdered[usingTab_id][i]--;

   	tablesArr[usingTab_id].total_amount -= itemsArr[i].cost;
    tablesArr[usingTab_id].total_items--;
    setTables();
    orderDetails("tab" + usingTab_id);
}

var closes1 = document.getElementById("bye");

// When the user clicks on <span> (x), close the modal
closes1.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside 
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function setTables(){
	var txt = '<table class="table table-hover"><thead><tr><th>Tables<br><input type="text" id="tableSearchInput" onkeyup="tableSearchFunction()" placeholder="Search for tables.."></th></tr></thead><tbody>';

	for (var i = 0; i < tablesArr.length; i++){
		txt += '<tr><td id = "tab'
		txt += i;
		txt += '" ondrop="drop(event)" ondragover="allowDrop(event)" onclick = "orderDetails(event.target.id)"><h5>'
		txt += tablesArr[i].name;
		txt += '</h5>Rs. ' ;
		txt += tablesArr[i].total_amount;
		txt += '<br>Total Items: ';
		txt += tablesArr[i].total_items;
		txt += '</td></tr>';
  	}

	txt += '</tbody></table>';
	tables.innerHTML = txt;
}

function setMenu(){
	var txt = '<table class="table table-hover"><thead><tr><th>Items<br><input type="text" id="itemSearchInput" onkeyup="itemSearchFunction()" placeholder="Search for items.."></th></tr></thead><tbody>';
	for(var i = 0; i < itemsArr.length; i++){
		txt += '<tr><td id = "item';
		txt += i;
		txt += '" draggable="true" ondragstart="dragstart_handler(event);">';
		txt += itemsArr[i].name;
		txt += ' (Rs. ';
		txt += itemsArr[i].cost;
		txt += ')</td></tr>';
	}
	txt += '</tbody></table>';
	items.innerHTML = txt;
}

function setRestaurants(){
	setTables();
	setMenu();
}

function tableSearchFunction() {
    // Declare variables
    var input, filter, tables, tablesArr, a, i;
    input = document.getElementById('tableSearchInput');
    filter = input.value.toUpperCase();
    tables = document.getElementById("tableList");
    tablesArr = tables.getElementsByTagName('td');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < tablesArr.length; i++) {
        a = tablesArr[i].getElementsByTagName('h5');
        if (a[0].innerHTML.toUpperCase().indexOf(filter) > -1) {
            tablesArr[i].style.display = "";
        } else {
            tablesArr[i].style.display = "none";
        }
    }
}

function itemSearchFunction() {
    // Declare variables
    var input, filter, items, itemsArr, a, i;
    input = document.getElementById('itemSearchInput');
    filter = input.value.toUpperCase();
    items = document.getElementById("itemList");
    itemsArr = items.getElementsByTagName('td');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < itemsArr.length; i++) {
        // a = itemsArr[i].getElementsByTagName('h5');
        if (itemsArr[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            itemsArr[i].style.display = "";
        } else {
            itemsArr[i].style.display = "none";
        }
    }
}


function dragstart_handler(ev) {
 console.log("dragStart");
 // Add the target element's id to the data transfer object
 ev.dataTransfer.setData("text/plain", ev.target.id);
 ev.dataTransfer.dropEffect = "copy";
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    // ev.target.appendChild(document.getElementById(data));
    // alert(data);
    var item_id = data[4];
    var tab_id = ev.target.id;
    tab_id = tab_id[3];
    itemsOrdered[tab_id][item_id]++;
    tablesArr[tab_id].total_amount += itemsArr[item_id].cost;
    tablesArr[tab_id].total_items++;
    setTables();
}
