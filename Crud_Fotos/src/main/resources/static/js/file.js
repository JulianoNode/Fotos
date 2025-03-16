$(document).ready(function() {
	moment.locale('pt-BR');
	var table = $('#table-fileCrud').DataTable({
		"language": { "url": "//cdn.datatables.net/plug-ins/1.13.2/i18n/pt-BR.json" },
		searching: true,
		order: [[1, "asc"]],
		lengthMenu: [2, 5, 10, 20, 50],
		processing: true,
		serverSide: true,
		responsive: true,
		ajax: {
			url: '/files/datatables/server',
			data: 'data'
		},
		columns: [
			{ data: 'id' },
			{
				data: 'id',
				render: function(id) {
					return `<img src="/files/image/${id}" width="50" height="50" style="border-radius:5px;" />`;
				}
			},
			{ data: 'titulo' },
			{ data: 'descricao' },
			{
				orderable: false,
				data: 'id',
				"render": function(id) {
					return '<a class="btn btn-success btn-sm btn-block" href="/files/editar/' +
						id + '" role="button"><i class="fas fa-edit"></i></a>';
				}
			},
			{
				orderable: false,
				data: 'id',
				"render": function(id) {
					return '<a class="btn btn-danger btn-sm btn-block" href="/files/excluir/' +
						id + '" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
				}
			}
		]
	});
});    
