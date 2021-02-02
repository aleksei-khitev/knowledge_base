<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1><xsl:value-of select="project/name"/></h1>
                <h2>Blockers</h2>
                <xsl:choose>
                    <xsl:when test="project/tickets/ticket[priority='P1'] != ''">
                        <table border="1">
                            <tr bgcolor="#9acd32">
                                <th>Key</th>
                                <th>Name</th>
                                <th>Due Date</th>
                            </tr>
                            <xsl:for-each select="project/tickets/ticket[priority='P1']">
                                <tr>
                                    <td><xsl:apply-templates select="key"/></td>
                                    <td><xsl:apply-templates select="name"/></td>
                                    <td><xsl:apply-templates select="due_date"/></td>
                                </tr>
                            </xsl:for-each>
                        </table>
                    </xsl:when>
                    <xsl:otherwise>
                        No blockers
                    </xsl:otherwise>
                </xsl:choose>
                <h2>Other Tickets</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Key</th>
                        <th>Name</th>
                        <th>Priority</th>
                        <th>Due Date</th>
                    </tr>
                    <xsl:for-each select="project/tickets/ticket[priority='P2']|project/tickets/ticket[priority='P3']">
                        <xsl:sort select="priority"/>
                        <tr>
                            <td><xsl:apply-templates select="key"/></td>
                            <td><xsl:apply-templates select="name"/></td>
                            <td><xsl:apply-templates select="priority"/></td>
                            <td><xsl:apply-templates select="due_date"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="key">
        <xsl:value-of select="."/>
    </xsl:template>

    <xsl:template match="name">
        <span style="font-weight: bold"><xsl:value-of select="."/></span>
    </xsl:template>

    <xsl:template match="priority">
        <span style="color:#ff0000"><xsl:value-of select="."/></span>
    </xsl:template>

    <xsl:template match="due_date">
        <xsl:if test=". != ''">
            <xsl:value-of select="."/>
        </xsl:if>
    </xsl:template>

</xsl:stylesheet>