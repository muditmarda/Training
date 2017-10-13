var tablesArr = JSON.parse(tables);
var itemsArr = JSON.parse(items);
var modal = document.getElementById('myModal');
var tables = document.getElementById('tableList');
var items = document.getElementById('itemList');
var itemsOrdered = new Array(tablesArr.length);
for (var i = 0; i < tablesArr.length; i++){
	itemsOrdered[i] = [];
}

// console.log();

function orderDetails(ev){
	var tab_id = ev.target.id;
	tab_id = tab_id[3];
	tab_id = parseInt(tab_id);
	var head = document.getElementById("modal-header-content");
	var txt = '<h4>Table ';
	var tab_num = tab_id + 1;
	txt += tab_num;
	txt += ' | Order Details</h4>'
	head.innerHTML = txt;
	var body = document.getElementById('modal-body');
	txt = '<table class="table table-hover" id = "myTable"><thead><tr><th>Sl. No.</th><th>Item</th><th>Price</th><th>Servings</th><th></th></thead><tbody>';
	for(var i = 0; i < itemsOrdered[tab_id].length; i++){
		txt += '<tr><td>';
		txt += i + 1;
		txt += '</td><td>';
		txt += itemsArr[itemsOrdered[tab_id][i]].name;
		txt += '</td><td>';
		txt += itemsArr[itemsOrdered[tab_id][i]].cost;
		txt += '</td><td><td><img src = "deleteIcon.png" class = "deleteItem" height = "15%"></td></td>';
	}
	txt += '</tbody></table>';
	body.innerHTML = txt;
	modal.style.display = "block";
	var deleteItems = document.getElementsByClassName("deleteItem");
	for(var i = 0; i < itemsOrdered[tab_id].length; i++){
		deleteItems[i].addEventListener("click", function(){
			document.getElementById("myTable").deleteRow(i);
		});
	}
}

var closes1 = document.getElementById("bye");

// When the user clicks on <span> (x), close the modal
closes1.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
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
		txt += '" ondrop="drop(event)" ondragover="allowDrop(event)" onclick = "orderDetails(event)"><h5>'
		txt += tablesArr[i].name;
		txt += '</h5>Rs. ' ;
		txt += tablesArr[i].total_amount;
		txt += '<br>Total Items: ';
		txt += tablesArr[i].total_items;
		txt += '</td></tr>';
		
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
    itemsOrdered[tab_id].push(item_id);
    tablesArr[tab_id].total_amount += itemsArr[item_id].cost;
    tablesArr[tab_id].total_items++;
    setTables();
    console.log(itemsOrdered);
}
