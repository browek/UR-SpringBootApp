$(document).ready( function () {
	 var table = $('#tabelaKlientow').DataTable({
			"sAjaxSource": "/listaklientow",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"columns": [
					{ "mData": "id"},
					{ "mData": "imie" },
					{ "mData": "nazwisko" },
					{ "mData": "pesel" }
					]
	 })
});


$(document).ready( function () {
	 var table = $('#tabelaSamochodow').DataTable({
			"sAjaxSource": "/listasamochodow",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
					{ "mData": "id"},
					{ "mData": "marka" },
					{ "mData": "model" },
					{ "mData": "rok_produkcji" },
//					{ defaultContent: '<b>Wyporzyczony przez:</b>'},
//					{ data: 'klient.imie'},
//					{ data: 'klient.nazwisko'},
//					{ data: 'klient.pesel'}
			]
	 })
});
