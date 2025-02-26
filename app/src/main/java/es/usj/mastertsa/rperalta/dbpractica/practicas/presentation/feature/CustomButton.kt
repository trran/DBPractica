package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.feature

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(115.dp)
            .height(50.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(text, color = Color.White, fontSize = 10.sp)
    }
}