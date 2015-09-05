var id2;
var id1;
function ajaxCall(url,id)
{
id1=id;
id2=id+1;
if (window.XMLHttpRequest)
{ req = new XMLHttpRequest();
}
else if (window.ActiveXObject)
{
req = new ActiveXObject("Microsoft.XMLHTTP");
}
req.open("GET", url, true);
req.onreadystatechange = callback;
req.send(null);
}

function callback()
{
if (req.readyState == 4)
{
if (req.status == 200)
{
 var msg = req.responseXML.getElementsByTagName("word")[0].firstChild.nodeValue;
 var complete = req.responseXML.getElementsByTagName("game")[0].firstChild.nodeValue;
 var bull = req.responseXML.getElementsByTagName("bull")[0].firstChild.nodeValue;
 var cow = req.responseXML.getElementsByTagName("cow")[0].firstChild.nodeValue;
 var realw = req.responseXML.getElementsByTagName("real")[0].firstChild.nodeValue;
 if(msg=="true"){
 if(complete=="false" && id2!="8")
 document.getElementById("button"+id2).disabled=false;
 document.getElementById("button"+id1).disabled=true;
 document.getElementById("bull"+id1).innerHTML=bull;
 document.getElementById("cow"+id1).innerHTML=cow; 
 if(id1==7){
 alert(realw);
   document.getElementById("spell"+id1).innerHTML="<font color='green'>"+realw+"</font>";
   }
 if(complete=="true")
   alert("huRRay");
 }
 
 if(msg=="false"){
    document.getElementById("spell"+id1).innerHTML="<font color='red'>spell?</font>";
 } 
 //alert(msg+id2);
 //alert(msg1);
}
}
}