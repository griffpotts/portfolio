Function CheckQuadratic(a, b, c, oneRoot)
    x = oneRoot
    y = a * x ^ 2 + b * x + c
    y = Round(y, 12)
    If y <> 0 Then
        CheckQuadratic = "X"
    End If
End Function

Function QuadraticPM(a, b, c, part As String)
    radicand = b ^ 2 - 4 * a * c
    If radicand < 0 Then
        QuadraticPM = -99999
    End If
    If part = "+" Then
        QuadraticPM = -b + radicand
    ElseIf part = "-" Then
        QuadraticPM = -b - radicand
    Else
        QuadraticPM = -88888
    End If
End Function

Sub hw62()
    For k = 1 To 10
        If IsEmpty(Cells(k + 1, 1)) Then
            Exit For
        End If
        Cells(k + 1, 5) = QuadraticPM(Cells(k + 1, 1), Cells(k + 1, 2), Cells(k + 1, 3), "+")
        Cells(k + 1, 6) = QuadraticPM(Cells(k + 1, 1), Cells(k + 1, 2), Cells(k + 1, 3), "-")
        Cells(k + 1, 8) = CheckQuadratic(Cells(k + 1, 1), Cells(k + 1, 2), Cells(k + 1, 3), Cells(k + 1, 5))
        Cells(k + 1, 9) = CheckQuadratic(Cells(k + 1, 1), Cells(k + 1, 2), Cells(k + 1, 3), Cells(k + 1, 6))
    Next k
End Sub
