package pe.edu.upc.easyvet.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.easyvet.R
import pe.edu.upc.easyvet.core.designsystem.theme.EasyVetTheme

@Composable
fun OnBoardingScreen() {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = "background"
        )


        Text(
            "From Bowl to Soul",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "We've Got It All!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)

                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Create Account")
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {

            },

            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.weight(1f))


    }

}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    EasyVetTheme(
        dynamicColor = false) {
        OnBoardingScreen()
    }
}