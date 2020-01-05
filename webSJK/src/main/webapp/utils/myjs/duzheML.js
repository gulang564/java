$(function () {
    $.ajax({
        type: "get",
        url: "/getReaderType",
        data: "",
        dataType: "json",
        success: function (response) {
            console.log(response);
            for (var i = 0; i <response.length ; i++) {
                var tr=$(" <tr>\n" +
                    "                    <td><label>"+response[i].rdTypeName+"</label></td>\n" +
                    "                    <td><label>"+response[i].canLendQty+"</label></td>\n" +
                    "                    <td><label>"+response[i].canLendDay+"</label></td>\n" +
                    "                    <td><label>"+response[i].canContinueTimes+"</label></td>\n" +
                    "                    <td><label>"+response[i].punishRate+"</label></td>\n" +
                    "                    <td><label>"+(response[i].dateValid==0?"永久":response[i].dateValid)+"</label></td>\n" +
                    "                </tr>")
                $("#table").append(tr);

            }

        }
    })




})