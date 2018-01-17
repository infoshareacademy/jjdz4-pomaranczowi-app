<h4>
    Ekstrema lokalne dla
    <c:out value="${data == 'fund' ? 'funduszu inwestycyjnego': 'waluty'} ${code}."/>
</h4>
<label for="chooseStartDate">Podaj date poczatkowa</label>
<input type="date" class="form-control" name="startDate" id="chooseStartDate" required>
<label for="chooseEndDate">Podaj date koncowa</label>
<input type="date" class="form-control" name="endDate" id="chooseEndDate" required>