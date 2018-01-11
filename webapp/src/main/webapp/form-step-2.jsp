<form action="form-with-steps" method="post">
    <p>Podaj kod funduszu/waluty:</p>
    <%--<select type="text" name = "chooseFundOrCurrency">
       <option>Notowania funduszy inwestycyjnych</option>
       <option>Notowania kursów walut</option>
   </select>
    <br />--%>
    <input type="hidden" name="step" value="2"/>
    <input type="text" name="code">
    <input type="submit" value="Submit">
</form>