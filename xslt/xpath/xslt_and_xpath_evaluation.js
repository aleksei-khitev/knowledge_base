function loadXMLDoc(filename) {
    xhttp = new XMLHttpRequest();
    xhttp.open("GET", filename, false);
    xhttp.send("");
    return xhttp.responseXML;
}

function displayXsltResult(xml, xsl) {
    if (document.implementation && document.implementation.createDocument){
        xsltProcessor = new XSLTProcessor();
        xsltProcessor.importStylesheet(xsl);
        resultDocument = xsltProcessor.transformToFragment(xml, document);
        document.getElementById("xsltResult").appendChild(resultDocument);
    }
}

function displayXPathResult(xmlFilePath, xPath) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var titleTextNode = document.createTextNode("XPath: " + xPath + "\n======");
            document.getElementById("xPathResult").appendChild(titleTextNode);
            var evaluatedXPath = evaluateXPath(xhttp.responseXML, xPath);
            var resultTextNode = document.createTextNode(evaluatedXPath + "=====\n");
            document.getElementById("xPathResult").appendChild(resultTextNode);
            document.body.style = "white-space: pre;"
        }
    };
    xhttp.open("GET", xmlFilePath, true);
    xhttp.send();
}

function evaluateXPath(xmlResponse, xPath) {
    var txt = "";
    if (xml.evaluate) {
        var iterator = xml.evaluate(xPath, xml, null, XPathResult.UNORDERED_NODE_ITERATOR_TYPE, null);
        var thisNode = iterator.iterateNext();
        while (thisNode) {
            txt += thisNode.textContent;
            thisNode = iterator.iterateNext();
        }
        /*while (result) {
            txt += result.childNodes[0].nodeValue;
            result = nodes.iterateNext();
        }*/
    }
    return txt;
}