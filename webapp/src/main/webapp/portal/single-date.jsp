<h4>
    Notowania z danego dnia dla
    <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
</h4>
<label for="chooseDate">Podaj date</label>
<input type="date" class="form-control" name="date" id="chooseDate" required>