$(document).ready(function() {
	var listContent = null; //for searching and show content
	var listContentDatabase = null; //for get content from db
	var contentTable = document.querySelector("#content-table");
});
getAllContent = function() {
	$ajax({
		url: "getContent",
		method: "GET",
		cache: false,
		success: function(result) {
			if (result != null) {
				listContentDatabase = JSON.parse(result);
				listContent = listContentDatabase

				console.log(listContent);
				if (listContent != null) {
					$("#content-table").css("display", "table");
					showlistContent(contentTable);

				} else {
					$("#none-content").css("display", "block");
					listContent = [];
				}
			}
		}
	})
}