<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1><xsl:value-of select="project/name"/></h1>
                <h2>Current Tickets</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Key</th>
                        <th>Name</th>
                    </tr>
                    <xsl:for-each select="project/tickets/ticket">
                        <tr>
                            <td><xsl:value-of select="key"/></td>
                            <td><xsl:value-of select="name"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>