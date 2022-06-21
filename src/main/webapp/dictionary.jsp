<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Dictionary</title>
    <link rel="stylesheet" href="css/styles.css">
  </head>
  <body>
      <s:include value="navbar.jsp"/>
      <main>
        
        <h1>Dictionary</h1>
        <p><a href="<s:url action='news'/>">View news</a></p>   
        <p><a href="<s:url action='dictionary'/>">View Dictionary</a></p>   

        <h1>Word: <s:property value="dictionaryResponse.word"/></h1>
        <h3>Definition: <s:property value="results.definition"/></h3>

        <s:iterator value="dictionaryResponse.results">
        <fieldset>
            <s:property value="word"/>
            <h3>Definition: <s:property value="results.definition"/></h3>
            <p>Part of Speech: <s:property value="partOfSpeech"/></p>
            <p>Synonyms: <s:property value="synonyms"/></p>
            <p>Attribute: <s:property value="attribute"/></p>
            <p>Similar to: <s:property value="similarTo"/></p>
            <p>Antonyms: <s:property value="antonyms"/></p>
            <p>Derivation: <s:property value="derivation"/></p>
            <p>Examples: <s:property value="examples"/></p>
        </fieldset>
        </s:iterator>

        <s:iterator value="dictionaryResponse.syllables">
          <fieldset>
            <h3>-Syllables-</h3>
            <p>Count: <s:property value="count"/></p>
            <s:iterator value="syllables.list">
              <fieldset>
                <p>List: <s:property value="list"/></p>
              </fieldset>
            </s:iterator>         
          </fieldset>
        </s:iterator>
        <s:iterator value="dictionaryResponse.syllables">
          <fieldset>
            <p><s:property value="all"/></p>
          </fieldset>
        </s:iterator>


      </main>
      <footer>
        <s:iterator value="dictionaryResponse.results">
        <fieldset>
            <s:property value="partOfSpeech"/>
            <h3><s:property value="definiton"/> by <s:property value="synonyms"/></h3>
            <s:property value="examples"/>
            <p>Read more: <a href="#"><s:property value="url"/></a></p>
        </fieldset>
    </s:iterator>
      </footer>
  </body>
</html>
