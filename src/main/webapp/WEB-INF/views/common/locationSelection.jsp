<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시도 및 구군 선택 폼</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>시도 및 구군 선택</h2>
        <form id="location-form">
            <div class="form-group">
                <label for="sido-select">시도 선택</label>
                <select class="form-control" id="sido-select" name="province">
                    <option value="">시도선택</option>
                </select>
            </div>
            <div class="form-group">
                <label for="gugun-select">구군 선택</label>
                <select class="form-control" id="gugun-select" name="city">
                    <option value="">구군선택</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">제출</button>
        </form>
    </div>

    <!-- 외부 라이브러리 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
    document.addEventListener('DOMContentLoaded', () => {
        fetchSidoList();
        document.getElementById('sido-select').addEventListener('change', fetchGugunList);
    });

    function fetchSidoList() {
        fetch('<c:url value="/location/getSidoList" />')
        .then(response => response.json())
        .then(data => {
            const sidoSelect = document.getElementById('sido-select');
            sidoSelect.innerHTML = '<option value="">시도선택</option>';
            data.forEach(sido => {
                const option = document.createElement('option');
                option.value = sido.code; // 시도 코드
                option.textContent = sido.name; // 시도 이름
                sidoSelect.appendChild(option);
            });
        })
        .catch(err => console.error('Error fetching 시도 list:', err));
    }

    function fetchGugunList() {
        const sidoCode = document.getElementById('sido-select').value;
        if (!sidoCode) {
            document.getElementById('gugun-select').innerHTML = '<option value="">구군선택</option>';
            return;
        }
        
        fetch('<c:url value="/location/getGugunList" />?sidoCode=' + sidoCode)
        .then(response => response.json())
        .then(data => {
            const gugunSelect = document.getElementById('gugun-select');
            gugunSelect.innerHTML = '<option value="">구군선택</option>';
            data.forEach(gugun => {
                const option = document.createElement('option');
                option.value = gugun.code; // 구군 코드
                option.textContent = gugun.name; // 구군 이름
                gugunSelect.appendChild(option);
            });
        })
        .catch(err => console.error('Error fetching 구군 list:', err));
    }
    </script>
</body>
</html>
