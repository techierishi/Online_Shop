$(function () {
 
    $('#fileupload').fileupload({
 
        dataType: 'json',
 
        done: function (e, data) {
            $("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
 
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').html('<img class="img_preview" src="'+file.filePath+file.fileName+'"/>'))
                        .append($('<td/>').text(file.fileSize))
                        .append($('<td/>').text(file.fileType))
 
                        )//end $("#uploaded-files").append()
            }); 
        },
 
        progressall: function (e, data) {
        	
            var progress = parseInt(data.loaded / data.total * 100, 10);
            console.log("progress : "+progress);
            $('#progress').progressbar({ value: progress });
        },
 
        dropZone: $('#dropzone')
    }).bind('fileuploadsubmit', function (e, data) {
           
    });
 
});
