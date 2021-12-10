


export type GetUserTokenResponse = {
    /**
    * userToken representing the user for which to fetch the Personalization profile.
    */
    userToken: string;
    /**
    * Date of last event update. (ISO-8601 format)
    */
    lastEventAt: Date;
    /**
    * The userToken scores.
    */
    scores: { [key: string]: object; };
}

