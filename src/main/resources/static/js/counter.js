const playmusic = document.querySelector("#playmusic");
const audio = new Audio();
let currentSoundIndex = 0;
let currentSequence = [];

const playSequence = (sounds) => {
    currentSequence = sounds;
    currentSoundIndex = 0;

    const playNextSound = () => {
        if (currentSoundIndex < currentSequence.length) {
            audio.src = currentSequence[currentSoundIndex++];
            audio.currentTime = 0;
            audio.play();
        }
    };

    // 기존 'ended' 이벤트 중복 방지
    audio.removeEventListener("ended", audio._onEnded);
    audio._onEnded = () => {
        if (currentSoundIndex < currentSequence.length) {
            playNextSound();
        } else {
            currentSoundIndex = 0;
            playNextSound();
        }
    };
    audio.addEventListener("ended", audio._onEnded);

    playNextSound();
};

playmusic.addEventListener("click", () => {
    if (audio.paused || audio.ended) {
        playSequence(["/audio/tenbyounoUta.mp3","/audio/내꺼하는법.mp3", "/audio/SUPADOPA.mp3"]);
    } else {
        audio.pause();
    }
});