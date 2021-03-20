var apiclient = (function () {

    var url = "/GetMessages";
    function addMessage (){
        var mensaje = document.getElementById("data").value;
        axios.post(url,{"mensaje" : mensaje , "fecha" : " "})
            .then(res => {
                    console.log(mensaje);
                    getMessages();
                }
            )
    }
    function getMessages(){

        $("#messages > tbody").empty();
        axios.get(url).then(res=>{
            console.log(res.data)
            res.data.map((message,index)=>{
                index +=1;
                $("#messages > tbody").append(
                    "<tr>" +
                    "<th scope='row'>"+ index + "</th>"+
                    " <td>" + message.mensaje + "</td>" +
                    "<td>" + message.fecha + "</td> " +
                    "</tr>"
                );
            })
        })
    }
    return {
        addMessage : addMessage,
        getMessages:getMessages
    };
})();